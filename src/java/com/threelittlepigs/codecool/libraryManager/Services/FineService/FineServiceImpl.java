package com.threelittlepigs.codecool.libraryManager.Services.FineService;

import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.util.Date;
import java.util.List;

public class FineServiceImpl implements FineService{

    @Override
    public Fine getFineById(int id) {
        List<Fine> fine = EntityUtility.findByOneCriteria(Fine.class, "id", String.valueOf(id));
        return fine.get(0) ;
    }

    @Override
    public void changeAmount(int id, double amount) {
        Fine fine = getFineById(id);
        fine.setAmount(amount);
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public void changeOccurrence(int id, Date occurrence) {
        Fine fine = getFineById(id);
        fine.setOccurrence(occurrence);
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public void changeDueDate(int id, Date dueDate) {
        Fine fine = getFineById(id);
        fine.setDueDate(dueDate);
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public void changeStatus(int id, boolean status) {
        Fine fine = getFineById(id);
        fine.setStatus(status);
        EntityUtility.mergeEntity(fine );
    }

    @Override
    public void changeMember(int fineId, int memberId) {
        Fine fine = getFineById(fineId);
        List<Member> members = EntityUtility.findByOneCriteria(User.class, "id", String.valueOf(memberId));
        fine.setMember(members.get(0));
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public List<Fine> getFinesByUserId(int id) {
        return EntityUtility.findByOneCriteria(Fine.class, "member_id", String.valueOf(id));
    }
}
