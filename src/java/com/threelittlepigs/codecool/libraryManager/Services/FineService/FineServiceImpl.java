package com.threelittlepigs.codecool.libraryManager.Services.FineService;

import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.util.Date;
import java.util.List;

public class FineServiceImpl implements FineService{
    @Override
    public void changeAmount(Fine fine, double amount) {
        fine.setAmount(amount);
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public void changeOccurrence(Fine fine, Date occurrence) {
        fine.setOccurrence(occurrence);
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public void changeDueDate(Fine fine, Date dueDate) {
        fine.setDueDate(dueDate);
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public void changeStatus(Fine fine, boolean status) {
        fine.setStatus(status);
        EntityUtility.mergeEntity(fine );
    }

    @Override
    public void changeMember(Fine fine, int id) {
        List<Member> members = EntityUtility.findByOneCriteria(User.class, "id", String.valueOf(id));
        fine.setMember(members.get(0));
        EntityUtility.mergeEntity(fine);
    }

    @Override
    public List<Fine> getFinesByUserId(int id) {
        return EntityUtility.findByOneCriteria(Fine.class, "member_id", String.valueOf(id));
    }
}
