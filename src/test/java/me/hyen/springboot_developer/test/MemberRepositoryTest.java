package me.hyen.springboot_developer.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // @Transactional이 포함되어있음
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers() {
        // when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberById() {
        // when
        Member member = memberRepository.findById(2L).get();

        //then
        assertThat(member.getName()).isEqualTo("B");
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberByName() {
        // when
        Member member = memberRepository.findByName("C").get();

        //then
        assertThat(member.getId()).isEqualTo(3);
    }

        @Test
        void saveMember() {
            // given
            Member member = new Member("A");  // id를 같이 그냥 보내버리면 에러가 나네
            // when
            memberRepository.save(member);

            //then
            assertThat(memberRepository.findById(3L).get().getName()).isEqualTo("A");
        }
        // 같이 돌리면 밑에거가 먼저 실행되는듯 그래서 1L 대신 3L로 해야 성공함

        @Test
        void saveAllMembers() {
            // given
            List<Member> members = List.of(new Member("B"), new Member( "C"));  // id를 같이 그냥 보내버리면 에러가 나네

            // when
            memberRepository.saveAll(members);

            //then
            assertThat(memberRepository.findAll().size()).isEqualTo(2);
        }

         //왜 saveMember랑 saveAllMembers를 같이 돌리면 오류가 날까?
         //id 배정이 A-1, B-2, C-3 이런게 아니라서
         //실행 순서가 위아래 보장이 아니라서 그래서 id = 1L인지 하드코딩으로 확인하는 것은 살짝 위험

        @Sql("/insert-members.sql")
        @Test
        void deleteMemberById() {
            // when
            memberRepository.deleteById(2L);

            //then
            assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
        }

        @Sql("/insert-members.sql")
        @Test
        void deleteAll() {
            // when
            memberRepository.deleteAll();

            //then
            // assertThat(memberRepository.findAll().isEmpty()).isTrue();
            // 이렇게도 되네용
            assertThat(memberRepository.findAll().size()).isZero();
        }

        // 보통은 다른 테스트가 다른 테스트 영향 안주게 하는데 삭제 사용
        @AfterEach
        void cleanUp() {
            memberRepository.deleteAll();
        }

        @Sql("/insert-members.sql")
        @Test
        void update() {
            // given
            Member member = memberRepository.findById(2L).get();

            // when
            member.changeName("BC");

            //then
            assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
        }
}