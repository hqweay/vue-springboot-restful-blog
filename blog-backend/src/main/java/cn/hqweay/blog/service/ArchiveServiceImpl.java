package cn.hqweay.blog.service;

import cn.hqweay.blog.dao.ArchiveMapper;
import cn.hqweay.blog.entity.Article;
import cn.hqweay.blog.service.interfaces.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description: TODO
 * Created by hqweay on 19-3-31 下午4:43
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {
  @Autowired
  private ArchiveMapper archiveMapper;

  @Override
  public ArrayList<Article> findArchivesByDay() {
    return archiveMapper.selectArchivesByDay();
  }
}
