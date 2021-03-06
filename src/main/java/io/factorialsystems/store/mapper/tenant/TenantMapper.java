package io.factorialsystems.store.mapper.tenant;

import io.factorialsystems.store.domain.tenant.Tenant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface TenantMapper {
    final String SELECT_TENANT = "Select id, organization, email, logo_url, base_url from tenants where id=#{tenant_id}";

    @Select(SELECT_TENANT)
    @Results(value = {
            @Result(property="id", column = "id"),
            @Result(property = "organization", column = "organization"),
            @Result(property = "email", column = "email"),
            @Result(property = "logo_url", column = "logo_url"),
            @Result(property = "base_url", column = "base_url")
    })
    Tenant findById(String tenant_id);

}
