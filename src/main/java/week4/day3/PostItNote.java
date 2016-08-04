package week4.day3;

import java.sql.*;
import java.util.Scanner;

public class PostItNote {
    private Scanner scanner = new Scanner(System.in);

    private String categoryName;
    private String categoryColor;
    private String categoryDescription;

    private String postItNoteTitle;
    private String postItNoteContent;
    private int postItNoteCategoryId;


    public static void main(String[] args) {
        PostItNote postItNote = new PostItNote();
//        postItNote.createCategoryTable();
//        postItNote.createPostItNoteTable();
        postItNote.askWhichOption();
    }

    private void askWhichOption() {
        String choice = "0";

        while(!(choice.equalsIgnoreCase("A") || choice.equalsIgnoreCase("B") ||choice.equalsIgnoreCase("C") || choice.equalsIgnoreCase("D"))) {
            System.out.println("What do you want to do? [A:create cat / B:view cats / C:create note / D:view notes]");
            choice = scanner.nextLine();
            System.out.println("You chose "+choice);
        }
        if(choice.equalsIgnoreCase("A")) {
            askAndSaveCategory();
        } else if(choice.equalsIgnoreCase("B")) {
            readAllCategoryRecords();
        } else if(choice.equalsIgnoreCase("C")) {
            askAndSavePostItNote();
        } else if (choice.equalsIgnoreCase("D")) {
            try {
                readAllJoinedRecords(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else  {
            System.out.println("WTF");
        }
    }

    private void askAndSaveCategory() {
        System.out.println("What is your Category Name?");
        categoryName = scanner.nextLine();
        System.out.println("What is your Category Color?");
        categoryColor = scanner.nextLine();
        System.out.println("What is your Category Description?");
        categoryDescription = scanner.nextLine();
        insertCategoryRecord();
    }

    private void askAndSavePostItNote() {
        System.out.println("What is your Note Title?");
        postItNoteTitle = scanner.nextLine();
        System.out.println("What is your Note Content?");
        postItNoteContent = scanner.nextLine();
        System.out.println("Pick a category number ["+getCategoryOptions()+"]");
        String tmpId = scanner.nextLine();
        postItNoteCategoryId = Integer.parseInt(tmpId);
        insertPostItNoteRecord();
    }

    private void dropCategoryTable() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE category;");

            stmt.close();
            conn.close();
            System.out.println("NOTE: Finished Update");
        } catch(Exception e) {
            System.out.println("No Category table to drop");
        }
    }

    private void dropPostItNoteTable() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE note;");

            stmt.close();
            conn.close();
            System.out.println("NOTE: Finished Update");
        } catch(Exception e) {
            System.out.println("No Note table to drop");
        }
    }

    private void createCategoryTable() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE category ( id INTEGER IDENTITY, catName VARCHAR(256), color VARCHAR(256), description VARCHAR(256))");

            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void createPostItNoteTable() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE note ( id INTEGER IDENTITY, title VARCHAR(256), content VARCHAR(256), categoryId INTEGER)");

            stmt.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readAllJoinedRecords(boolean printMe) throws Exception{
        Class.forName("org.hsqldb.jdbcDriver");
        Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * from note");
        ResultSet rs = stmt.executeQuery("SELECT note.title, note.content, category.catName " +
                                            "FROM note LEFT JOIN category " +
                                            "ON note.categoryId = category.id;");
        while(rs.next()) {
            String rowResults = rs.getString("note.title")+" -- "+rs.getString("note.content")+" -- "+rs.getString("category.catName");
            if(printMe) {
                System.out.println(rowResults);
            }
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    private void readAllCategoryRecords() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, catName, color, description from category");
            while(rs.next()) {
                String rowResults = rs.getInt("id")+" -- "+rs.getString("catName")+" -- "+rs.getString("color")+" -- "+rs.getString("description");
                System.out.println(rowResults);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getCategoryOptions() {
        String options = "";
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, catName from category");
            while(rs.next()) {
                options += " "+rs.getInt("id") +":"+rs.getString("catName")+" ";
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(options.isEmpty()) {
            options = "No Options";
        }
        return options;
    }

    private void insertCategoryRecord() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO category (catName, color, description) VALUES (?,?,?);");
            stmt.setString(1,categoryName);
            stmt.setString(2,categoryColor);
            stmt.setString(3,categoryDescription);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            System.out.println("NOTE: Finished CATEGORY Update");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void insertPostItNoteRecord() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:postitnote","sa","");
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO note (title, content, categoryId) VALUES (?,?,?);");
            stmt.setString(1,postItNoteTitle);
            stmt.setString(2,postItNoteContent);
            stmt.setInt(3,postItNoteCategoryId);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            System.out.println("NOTE: Finished NOTE Update");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
