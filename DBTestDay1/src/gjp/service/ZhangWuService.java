package gjp.service;

import gjp.dao.ZhangWuDao;
import gjp.domain.ZhangWu;

import java.util.List;

public class ZhangWuService {
    ZhangWuDao zhangWuDao = new ZhangWuDao();

    public List<ZhangWu> queryAll() {
        return zhangWuDao.queryAll();
    }

    public boolean insert(ZhangWu mZhangWu) {
        return zhangWuDao.insert(mZhangWu);
    }
}
