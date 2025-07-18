//package me.hyen.springboot_developer;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class TestDataInit {
//
//    private final MemberRepository memberRepository;
//
//    @PostConstruct //Spring Bean이 생성되고 의존성 주입이 완료된 후 자동으로 실행
//    public void init() {
//        memberRepository.save(new Member(1L, "내용 1"));
//        memberRepository.save(new Member(2L, "내용 2"));
//        memberRepository.save(new Member(3L, "내용 3"));
//    }
//}
