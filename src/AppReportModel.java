import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class AppReportModel  implements ModelInterface {
    

	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("OrgID,EmpID,TotalAppCount,AcceptedAppCount,RejectedAppCount,TopSecretApps,ObjectionDemandCount ");
		sql.append(" FROM AppReport ");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		sql.append("ORDER BY OrgID");		
		

		
		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		
		return result;
	}
		
	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception
	{
		int rowCount=0;
		return rowCount;
	}
	
	@Override
	public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
	{
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE AppReport SET  ");
		int appendCount = 0;
		for (Map.Entry<String, Object> entry : updateParameters.entrySet()) {
			sql.append(entry.getKey() + " = " + DatabaseUtilities.formatField(entry.getValue()));
			if (++appendCount < updateParameters.size()) {
				sql.append(", ");
			}
		}
		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		//System.out.println(sql.toString());
		
	
		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);		
		int rowCount = preparedStatement.executeUpdate();
		preparedStatement.close();
		
		return rowCount;
	}

	@Override
	public int delete(Map<String,Object> whereParameters) throws Exception
	{
		int rowCount=0;
		return rowCount;
	}

	@Override
	public String toString() {
		return "AppReport Model";
	}
    
    
    
    
}
