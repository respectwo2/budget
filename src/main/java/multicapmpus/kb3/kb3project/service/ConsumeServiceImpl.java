package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeServiceImpl implements ConsumeService {

    private final ConsumeMapper consumeMapper;

    public ConsumeServiceImpl(ConsumeMapper consumeMapper) {
        this.consumeMapper = consumeMapper;
    }


    @Override
    public List<ConsumeForFeed> getConsumesForFeed(int groupNo) {
        List<ConsumeForFeed> consumesForFeed = consumeMapper.selectConsumesWithCommentNumByGroupNo(groupNo);
        return consumesForFeed;
    }

    @Override
    public int increaseLike(int consumeNo) {
        int result = consumeMapper.updateLike(consumeNo);
        return result;
    }

    @Override
    public ConsumeWithUserName getConsumeByConsumeNo(int consumeNo) {
        ConsumeWithUserName consume = consumeMapper.selectOneByConsumeNo(consumeNo);
        return consume;
    }

    @Override  // 사용X
    public List<ConsumeWithUserName> getConsumes(int groupNo) {
        List<ConsumeWithUserName> consumes = consumeMapper.selectConsumesByGroupNo(groupNo);
        return consumes;
    }
}
