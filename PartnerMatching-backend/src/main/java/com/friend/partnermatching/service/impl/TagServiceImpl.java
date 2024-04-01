package com.friend.partnermatching.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.friend.partnermatching.model.domain.Tag;
import com.friend.partnermatching.mapper.TagMapper;
import com.friend.partnermatching.service.TagService;
import org.springframework.stereotype.Service;

/**
* @author LJW
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-03-12 00:27:27
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




