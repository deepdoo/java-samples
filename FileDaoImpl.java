package .dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mr_ge.xxx.dao.FileDao;
import com.mr_ge.xxx.dao.entity.FileEntity;

public class FileDaoImpl implements FileDao {

    @Resource
    private DataSource ds;

    @Override
    public int update(FileEntity fe) throws SQLException {

        return new QueryRunner(ds).update("update file set caption=?, "
                + "description=?, " + "content=?, " + "ext=?, "
                + "isDirectory=?, " + "parentId=?, " + "createId=?, "
                + "createTime=?, " + "updateId=?, " + "updateTime=? "
                + "where id=?", fe.getCaption(), fe.getDescription(),
                fe.getContent(), fe.getExt(), fe.getIsDirectory(),
                fe.getParentId(), fe.getCreateId(), fe.getCreateTime(),
                fe.getUpdateId(), fe.getUpdateTime(), fe.getId());
    }

    @Override
    public int insert(FileEntity fe) throws SQLException {

        return new QueryRunner(ds).update(
                "insert into file values(?,?,?,?,?,?,?,?,?,?,?)", fe.getId(),
                fe.getCaption(), fe.getDescription(), fe.getContent(),
                fe.getExt(), fe.getIsDirectory(), fe.getParentId(),
                fe.getCreateId(), fe.getCreateTime(), fe.getUpdateId(),
                fe.getUpdateTime());
    }

    @Override
    public List<FileEntity> getAll() throws SQLException {
        List<FileEntity> result = new QueryRunner(ds).query(
                "select * from file", new BeanListHandler<FileEntity>(
                        FileEntity.class));
        return result;
    }

    @Override
    public FileEntity getById(long id) throws SQLException {
        return new QueryRunner(ds).query("select * from file where id=?",
                new BeanHandler<>(FileEntity.class), id);
    }

    @Override
    public List<FileEntity> getByParent(long parentId) throws SQLException {
        List<FileEntity> result = new QueryRunner(ds).query(
                "select * from file where parentId=?",
                new BeanListHandler<FileEntity>(FileEntity.class), parentId);
        return result;
    }

    @Override
    public int delete(long id) throws SQLException {
        return new QueryRunner(ds).update("delete from file where id=?", id);
    }

}
