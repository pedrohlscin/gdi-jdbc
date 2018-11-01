package bo;

import database.JDBCConnection;
import poco.Image;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class ImageDAO {
    private Connection conn;

    public ImageDAO() {
        try {
            this.conn = JDBCConnection.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Image> getImages() {
        ArrayList<Image> imagens = new ArrayList<>();
        try {
            String sql = "select * from imgtable";
            Statement stm = this.conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                Image img = new Image();
                img.name = result.getString(1);
                img.blob = result.getBlob(2);
                imagens.add(img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagens;
    }

    public boolean insert(String nome, String filepath) throws SQLException {
        try {
            String sql = "INSERT INTO imgtable (name, photo) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            FileInputStream fis = new FileInputStream(filepath);
            statement.setString(1, nome);
            statement.setBinaryStream(2, fis, fis.available());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0)
                return true;
            else
                return false;
        }catch (SQLException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(Image img) {
        try {
            PreparedStatement stmt = conn.prepareStatement("delete " +
                    "from imgtable where name=? and photo=?");
            stmt.setString(1, img.name);
            stmt.setBlob(1, img.blob);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Image find(String nome) throws SQLException {
        ArrayList<Image> images = new ArrayList<>();
        try {
            String sql = "SELECT * from imgtable where name='" + nome + "'";
            Statement stm = this.conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                Image img_temp = new Image();
                img_temp.name = result.getString(1);
                img_temp.blob = result.getBlob(2);
                images.add(img_temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(images.size() == 1)
            return images.get(0);
        else if (images.size()>1)
            throw new SQLException("To many results!");
        else
            throw new SQLException("No data found!");
    }
}
