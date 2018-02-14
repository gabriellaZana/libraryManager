package com.threelittlepigs.codecool.libraryManager.Services;

import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.util.Date;
import java.util.List;

public interface FineService {

    public Fine getFineById(int id);

    public void changeAmount(int id, double amount);

    public void changeOccurrence(int id, Date occurrence);

    public void changeDueDate(int id, Date dueDate);

    public void changeStatus(int id, boolean status);

    public void changeMember(int fineId , int memberId);

    public List<Fine> getFinesByUserId(int id);
}
