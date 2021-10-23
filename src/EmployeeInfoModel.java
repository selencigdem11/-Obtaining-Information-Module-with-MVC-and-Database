
import java.sql.*;
import java.util.*;


class EmployeeInfoModel implements ModelInterface {
	
	@Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		// construct SQL statement
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append("EmployeeID, FirstName,MiddleName,LastName,Birthday,Email,Address,EducationState,StartDay,ManagerID,Authority");
		sql.append(" FROM EmployeeInformation");

		List<Map.Entry<String, Object>> whereParameterList = DatabaseUtilities.createWhereParameterList(whereParameters);		
		sql.append(DatabaseUtilities.prepareWhereStatement(whereParameterList));
		
		sql.append("ORDER BY EmployeeID");		
		//System.out.println(sql.toString() + "\n");

		
		// execute constructed SQL statement
		Connection connection = DatabaseUtilities.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		DatabaseUtilities.setWhereStatementParameters(preparedStatement, whereParameterList);
		ResultSet result = preparedStatement.executeQuery();
		return result;
	}
		
	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception
	{int rowCount=0;
		return rowCount;
	}
	
	@Override
	public int update(Map<String,Object> updateParameters, Map<String,Object> whereParameters) throws Exception
	{int rowCount=0;
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
		return "EmployeeInformation Model";
	}		
}
