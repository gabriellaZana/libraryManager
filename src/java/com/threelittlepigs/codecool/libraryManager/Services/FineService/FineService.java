package com.threelittlepigs.codecool.libraryManager.Services.FineService;

import com.threelittlepigs.codecool.libraryManager.Entities.Fine;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.Member;
import com.threelittlepigs.codecool.libraryManager.Entities.Users.User;
import com.threelittlepigs.codecool.libraryManager.Utils.EntityUtility;

import java.util.Date;
import java.util.List;

public interface FineService {

    public void changeAmount(Fine fine, double amount);

    public void changeOccurrence(Fine fine, Date occurrence);

    public void changeDueDate(Fine fine, Date dueDate);

    public void changeStatus(Fine fine, boolean status);

    public void changeMember(Fine fine, int id);

    public List<Fine> getFinesByUserId(int id);
}
