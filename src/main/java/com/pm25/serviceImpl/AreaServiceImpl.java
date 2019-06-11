package com.pm25.serviceImpl;

import com.pm25.dao.AreaDao;
import com.pm25.service.AreaService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements AreaService {
    AreaDao areaDao;
    public List<String> getAllArea() {
        areaDao = new AreaDao();
        List<String> list  = areaDao.selectAllArea();
        return list;
    }
}
