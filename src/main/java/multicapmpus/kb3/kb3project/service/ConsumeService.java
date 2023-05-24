package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.extra.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;

import java.util.List;

public interface ConsumeService {

    public List<ConsumeForFeed> getConsumesForFeed(int groupNo);

    public ConsumeWithUserName getConsumeByConsumeNo(int consumeNo);  //해당 소비글 불러오기 (댓글 모달창)

    public List<ConsumeWithUserName> getConsumes(int groupNo);  //그룹의 모든 소비글 조회 - 사용X
}
