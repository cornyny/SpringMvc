package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<Long, Member>();
    private static long sequence = 0L;

    // 1. 유일한 인스턴스를 저장하는 정적 상수
    private static final  MemberRepository instance = new MemberRepository();

    // 2. 유일한 인스턴스에 접근하기 위한 정적 메서드
    public static MemberRepository getInstance() {
        return instance;
    }

    // 3. private 접근 제어자를 가진 생성자
    private MemberRepository() {
        System.out.println("MemberRepository instance created");
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return  new ArrayList<Member>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
