package cn.edu.hit.rcare.mapper;

import cn.edu.hit.rcare.pojo.Sign;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class JsonTypeHandler<T> extends BaseTypeHandler<List<T>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final JavaType type;

    public JsonTypeHandler(Class<T> type) {
        objectMapper.registerModule(new JavaTimeModule());
        if (type == null) throw new IllegalArgumentException("Type argument cannot be null");
        this.type = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<T> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, toJson(parameter));
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toObject(rs.getString(columnName));
    }

    @Override
    public List<T> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toObject(rs.getString(columnIndex));
    }

    @Override
    public List<T> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toObject(cs.getString(columnIndex));
    }

    private String toJson(List<T> object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<T> toObject(String content) {
        if (content != null && !content.isEmpty()) {
            try {
                return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, Sign.class));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
