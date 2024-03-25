package Utilitys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

public class TestFile {

	public static void main(String[] args) throws SQLException {
		
		String expectedRolesNameList ="Finance Lead,Finance Reviewer,Finance Preparer,Report Viewer,Admin";
		
		String[] rolesCheck = expectedRolesNameList.split(",");
		
		for (String word : rolesCheck) 
		{
			System.out.println("word: "+word);
        }
		
		for(int i=1;i<=5;i++)
		{	
			int Count =i+1;
			System.out.println("Count: "+Count);
		}
		
			String connection = "jdbc:sqlserver://db.satva.solutions:59763;database=Howard_Staging;user=sa;password=Fishy1213#;integratedSecurity=false;";
			Connection con = DriverManager.getConnection(connection);
			
			Statement st = con.createStatement();
			String sqlStr = "SELECT * FROM [dbo].[Group]";
			ResultSet rs = st.executeQuery(sqlStr);
			while (rs.next()) {
				System.out.println(rs.getString("GroupName"));
			}
			
	
	}
}
