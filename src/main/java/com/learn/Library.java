package com.learn;

import java.sql.*;
import java.time.LocalDate;

public class Library {
    public void issueBook(int bookId, int userId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Check if book is available
            PreparedStatement ps = conn.prepareStatement("SELECT is_issued FROM books WHERE book_id = ?");
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && !rs.getBoolean("is_issued")) {
                // Mark as issued
                PreparedStatement updateBook = conn.prepareStatement("UPDATE books SET is_issued = true WHERE book_id = ?");
                updateBook.setInt(1, bookId);
                updateBook.executeUpdate();

                // Record issue
                PreparedStatement issue = conn.prepareStatement("INSERT INTO issued_books (book_id, user_id, issue_date) VALUES (?, ?, ?)");
                issue.setInt(1, bookId);
                issue.setInt(2, userId);
                issue.setDate(3, Date.valueOf(LocalDate.now()));
                issue.executeUpdate();

                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is already issued.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId, int userId) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Mark as returned
            PreparedStatement updateBook = conn.prepareStatement("UPDATE books SET is_issued = false WHERE book_id = ?");
            updateBook.setInt(1, bookId);
            updateBook.executeUpdate();

            // Update return date
            PreparedStatement returnBook = conn.prepareStatement(
                "UPDATE issued_books SET return_date = ? WHERE book_id = ? AND user_id = ? AND return_date IS NULL");
            returnBook.setDate(1, Date.valueOf(LocalDate.now()));
            returnBook.setInt(2, bookId);
            returnBook.setInt(3, userId);
            returnBook.executeUpdate();

            System.out.println("Book returned successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

