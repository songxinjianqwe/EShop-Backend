package cn.sinjinsong.eshop.core.dao.mail;

import cn.sinjinsong.eshop.core.BaseSpringTest;
import cn.sinjinsong.eshop.core.dao.user.UserDOMapper;
import cn.sinjinsong.eshop.core.domain.entity.mail.MailDO;
import cn.sinjinsong.eshop.core.enumeration.mail.MailStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SinjinSong on 2017/10/6.
 */
public class MailDOMapperTest extends BaseSpringTest{
    @Autowired
    private MailDOMapper mailDOMapper;
    @Autowired
    private UserDOMapper userDOMapper;
    @Test
    public void insert() throws Exception {
        MailDO mail = new MailDO();
        mail.setMailStatus(MailStatus.NOT_VIEWED);
        mail.setSender(userDOMapper.selectByPrimaryKey(1L));
        mail.setReceiver(userDOMapper.selectByPrimaryKey(2L));
        mailDOMapper.insert(mail);
    }

}