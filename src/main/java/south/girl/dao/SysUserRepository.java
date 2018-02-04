package south.girl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import south.girl.entity.SysUser;

/**
 * Created by zhang_w on 2018/2/4.
 */

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
