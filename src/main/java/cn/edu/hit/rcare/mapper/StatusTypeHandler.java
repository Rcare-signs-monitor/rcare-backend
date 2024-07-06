package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusTypeHandler extends BaseTypeHandler<Status> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Status parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, toJson(parameter));
    }

    @Override
    public Status getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toObject(rs.getString(columnName));
    }

    @Override
    public Status getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toObject(rs.getString(columnIndex));
    }

    @Override
    public Status getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toObject(cs.getString(columnIndex));
    }

    private String toJson(Status object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Status toObject(String content) {
        if (content != null && !content.isEmpty()) {
            try {
                return objectMapper.readValue(content, Status.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
