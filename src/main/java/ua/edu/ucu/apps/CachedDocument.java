package ua.edu.ucu.apps;

import java.sql.*;

public class CachedDocument extends AbstractDecorator {
    private static final String DB_URL = "jdbc:sqlite:newdb.sqlite";

    public CachedDocument(Document document) {
        super(document);
    }
    @Override
    public String parse(String path) {
        String query = "SELECT parse_text FROM files WHERE path = ?";
        String insertSQL = "INSERT OR REPLACE INTO files (path, parse_text) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement selectStmt = conn.prepareStatement(query);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
            selectStmt.setString(1, path);
            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                System.out.println("Taken from cache");
                return rs.getString("parse_text");
            }
            String parsedContent = super.parse(path);
            insertStmt.setString(1, path);
            insertStmt.setString(2, parsedContent);
            insertStmt.executeUpdate();
            return parsedContent;
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return super.parse(path);
    }
}