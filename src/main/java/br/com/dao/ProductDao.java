package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.beans.Product;
import br.com.utils.DbUtil;

public class ProductDao {
	private Connection connection;
	
	public ProductDao() {
		connection = DbUtil.getConnection();
	}
	
	public void addProduct (Product product) {
		String sql = "INSERT INTO products (name, category, amount) VALUES (?,?,?)";

		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setString(2, product.getCategory());
			st.setBigDecimal(3, product.getAmount());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Product> getAllProducts() {
		List<Product> productsList = new ArrayList<Product>();
		
		String sql = "SELECT * FROM products";
			
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
	            Product products = new Product();
	            products.setId(rs.getInt("id"));
	            products.setName(rs.getString("name"));
	            products.setCategory(rs.getString("category"));
	            products.setAmount(rs.getBigDecimal("amount"));
	            productsList.add(products);
	        }
			
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsList;
	}
	
	public Product getProductById(int id) {
        Product product = new Product();
        try {
            PreparedStatement st = connection.prepareStatement("select * from products where id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
            	product.setId(rs.getInt("id"));
            	product.setName(rs.getString("name"));
            	product.setCategory(rs.getString("category"));
            	product.setAmount(rs.getBigDecimal("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return product;
    }
	public void deleteProduct(Integer id) {
		String sql = "delete from products where id=?";
        try {
        
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void updateProduct(Product product) {
		String sql = "update product set  name=?, category=?, amount=? where id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setString(2, product.getCategory());
			st.setBigDecimal(3, product.getAmount());
			st.setInt(4, product.getId());
			st.executeUpdate();
			System.out.println("Atualizado com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
