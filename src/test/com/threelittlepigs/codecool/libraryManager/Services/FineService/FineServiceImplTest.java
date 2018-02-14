package com.threelittlepigs.codecool.libraryManager.Services.FineService;

import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FineServiceImplTest {

    private FineService fineService;
    private Fine fine;

    @BeforeAll
    void init() {
        fineService = new FineServiceImpl();
        fine = fineService.getFineById(1);
    }

    @Test
    void changeAmountTest() {

        Double formerAmount = fine.getAmount();
        //System.out.println(formerAmount);
        fineService.changeAmount((int) fine.getId(), formerAmount + 5);
        Double presentAmount = fine.getAmount();
        //System.out.println(presentAmount);
        assertNotEquals(formerAmount, presentAmount);
    }

    @Test
    void changeOccuranceTest() {
        Date formerDate = fine.getOccurrence();
        Date presentDate = new Date();
        fineService.changeOccurrence((int) fine.getId(), presentDate);
        System.out.println(formerDate);
        System.out.println(presentDate);
        assertNotEquals(formerDate, presentDate);

    }

    @Test
    void changeDueDateTest() {
        Date formerDate = fine.getDueDate();
        Date presentDate = new Date();
        fineService.changeDueDate((int) fine.getId(), presentDate);
        System.out.println(formerDate);
        System.out.println(presentDate);
        assertNotEquals(formerDate, presentDate);
    }

    @Test
    void changeStatusTest() {
        Boolean formerStatus = fine.isStatus();
        fineService.changeStatus((int) fine.getId(), !formerStatus);
        System.out.println(formerStatus);
        System.out.println(fine.isStatus());
        assertNotEquals(formerStatus, fine.isStatus());
    }

    @Test
    void changeMemberTest() {
        Member member = mock(Member.class);
        when(member.getId()).thenReturn(2L);
        fineService.changeMember((int) fine.getId(), (int)member.getId());
        assertEquals(member.getId(), fine.getMember().getId());
    }

    // TODO
    @Test
    void getFinesByUserIdTest() {
        /*Member member = mock(Member.class);
        when(member.getId()).thenReturn(2L);
        List<Fine> userFines = EntityUtility.findByOneCriteria(Fine.class, "member", "2");
        assertEquals(1, userFines.size());*/
    }

    @Test
    void getFineByIdTest() {
        assertEquals(1, fine.getId());
    }

}