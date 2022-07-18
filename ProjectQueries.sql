DROP PROCEDURE IF EXISTS Query1
DROP PROCEDURE IF EXISTS Query2a
DROP PROCEDURE IF EXISTS Query2b
DROP PROCEDURE IF EXISTS Query3a
DROP PROCEDURE IF EXISTS Query3b
DROP PROCEDURE IF EXISTS Query4
DROP PROCEDURE IF EXISTS Query5a
DROP PROCEDURE IF EXISTS Query5b
DROP PROCEDURE IF EXISTS Query6
DROP PROCEDURE IF EXISTS Query7a
DROP PROCEDURE IF EXISTS Query7b
DROP PROCEDURE IF EXISTS Query8a
DROP PROCEDURE IF EXISTS Query8b
DROP PROCEDURE IF EXISTS Query9a
DROP PROCEDURE IF EXISTS Query9b
DROP PROCEDURE IF EXISTS Query10
DROP PROCEDURE IF EXISTS Query11
DROP PROCEDURE IF EXISTS Query12
DROP PROCEDURE IF EXISTS Query13
DROP PROCEDURE IF EXISTS Query14
DROP PROCEDURE IF EXISTS Query15
DROP PROCEDURE IF EXISTS Query16
DROP PROCEDURE IF EXISTS Query17
DROP PROCEDURE IF EXISTS Query18
DROP PROCEDURE IF EXISTS Query19

/*** Queries to insert a new team ***/
GO 
CREATE PROCEDURE Query1 (@Name as VARCHAR(64),
                            @Type as VARCHAR(16),
                            @Date as VARCHAR(15))
AS
BEGIN
    INSERT INTO Teams 
        (TeamName, TeamType, Date_Formed)
    VALUES
        (@Name, @Type, @Date)
END;

/*** Queries to insert new client and associate them to their team(s) ***/
GO 
CREATE PROCEDURE Query2a (@SS as INT, @Name as VARCHAR(64),
                        @DoB as VARCHAR(10), @Race as VARCHAR(32),
                        @Gender as VARCHAR(8), @Prof as VARCHAR(64),
                        @MAdd as VARCHAR(64), @Email as VARCHAR(32),
                        @Home as VARCHAR(16), @Work as VARCHAR(16),
                        @Cell as VARCHAR(16), @Mail as VARCHAR(3),
                        @DName as VARCHAR(64), @DNum as VARCHAR(16),
                        @AName as VARCHAR(64), @ANum as VARCHAR(16),
                        @Date as VARCHAR(10))
AS
BEGIN
    INSERT INTO Person 
        (SocialSecurity, PersonName, DateOfBirth, Race, Gender, Profession)
    VALUES
        (@SS, @Name, @DoB, @Race, @Gender, @Prof)

    INSERT INTO ContactInfo
        (SocialSecurity, MailingAddress, Email, PhoneNumber_Home, PhoneNumber_Work, PhoneNumber_Cell, On_MailingList)
    VALUES
        (@SS, @MAdd, @Email, @Home, @Work, @Cell, @Mail)

    INSERT INTO Clients
        (SocialSecurity, Doctor_Name, Doctor_Number, Attorney_Name, Attorney_Number, Assignment_Date)
    VALUES  
        (@SS, @DName, @DNum, @AName, @ANum, @Date)

END;


GO
CREATE PROCEDURE Query2b (@SS as INT, @TName as VARCHAR(64), @Active as VARCHAR(30))
AS
BEGIN
    INSERT INTO Cares_For
        (SocialSecurity, TeamName, Is_Active)
    VALUES
        (@SS, @TName, @Active)
END;

/*** Queries to insert new volunteer and associate them with their team(s) ***/
GO 
CREATE PROCEDURE Query3a (@SS as INT, @Name as VARCHAR(64),
                        @DoB as VARCHAR(10), @Race as VARCHAR(32),
                        @Gender as VARCHAR(8), @Prof as VARCHAR(64),
                        @MAdd as VARCHAR(64), @Email as VARCHAR(32),
                        @Home as VARCHAR(16), @Work as VARCHAR(16),
                        @Cell as VARCHAR(16), @Mail as VARCHAR(3),
                        @Join as VARCHAR(10), @CourseD as VARCHAR(10),
                        @CourseL as VARCHAR(32))
AS
BEGIN
    INSERT INTO Person 
        (SocialSecurity, PersonName, DateOfBirth, Race, Gender, Profession)
    VALUES
        (@SS, @Name, @DoB, @Race, @Gender, @Prof)

    INSERT INTO ContactInfo
        (SocialSecurity, MailingAddress, Email, PhoneNumber_Home, PhoneNumber_Work, PhoneNumber_Cell, On_MailingList)
    VALUES
        (@SS, @MAdd, @Email, @Home, @Work, @Cell, @Mail)

    INSERT INTO Volunteers
        (SocialSecurity, Date_Joined, Course_Date, Course_Location)
    VALUES  
        (@SS, @Join, @CourseD, @CourseL)

END;

GO 
CREATE PROCEDURE Query3b (@SS as INT, @TName as VARCHAR(64), 
                        @Active as VARCHAR(3))
AS
BEGIN
    INSERT INTO On_Team
        (SocialSecurity, TeamName, Is_Active)
    VALUES
        (@SS, @TName, @Active)
END;

/*** Queries to insert number of hours a volunteer worked for a team ***/
GO 
CREATE PROCEDURE Query4 (@SS as INT,
                        @Name as VARCHAR(64),
                        @Month as VARCHAR(10),
                        @Hrs as INT)
AS
BEGIN
    INSERT INTO HoursWorked 
        (SocialSecurity, TeamName, MonthWorked, WorkedHours)
    VALUES
        (@SS, @Name, @Month, @Hrs)
END;

/*** Queries to insert new employee and associate them with their team(s) ***/
GO 
CREATE PROCEDURE Query5a (@SS as INT, @Name as VARCHAR(64),
                        @DoB as VARCHAR(10), @Race as VARCHAR(32),
                        @Gender as VARCHAR(8), @Prof as VARCHAR(64),
                        @MAdd as VARCHAR(64), @Email as VARCHAR(32),
                        @Home as VARCHAR(16), @Work as VARCHAR(16),
                        @Cell as VARCHAR(16), @Mail as VARCHAR(3),
                        @Sal as INT, @Mar as VARCHAR(10),
                        @HDate as VARCHAR(10))
AS
BEGIN
    INSERT INTO Person 
        (SocialSecurity, PersonName, DateOfBirth, Race, Gender, Profession)
    VALUES
        (@SS, @Name, @DoB, @Race, @Gender, @Prof)

    INSERT INTO ContactInfo
        (SocialSecurity, MailingAddress, Email, PhoneNumber_Home, PhoneNumber_Work, PhoneNumber_Cell, On_MailingList)
    VALUES
        (@SS, @MAdd, @Email, @Home, @Work, @Cell, @Mail)

    INSERT INTO Employees
        (SocialSecurity, Salary, Marital_Status, Hire_Date)
    VALUES  
        (@SS, @Sal, @Mar, @HDate)
END;


GO 
CREATE PROCEDURE Query5b (@SS as INT, @Rdate as VARCHAR(10), 
                        @TName as VARCHAR(64), @RDes as VARCHAR(150))
AS
BEGIN
    INSERT INTO Reports
        (SocialSecurity, TeamName, Report_Date, Report_Description)
    VALUES
        (@SS, @TName, @Rdate, @RDes)
END;

/*** Queries to insert an expense made by an employee ***/
GO 
CREATE PROCEDURE Query6 (@SS as INT,
                        @Date as VARCHAR(10),
                        @Amount as INT,
                        @Des as VARCHAR(150))
AS
BEGIN
    INSERT INTO Expenses
        (SocialSecurity, Expense_Date, Amount, Expense_Description)
    VALUES
        (@SS, @Date, @Amount, @Des)
END;

/*** Queries to insert new organization and associate them with their team(s) ***/
GO 
CREATE PROCEDURE Query7a (@OName as VARCHAR(64), @Mail as VARCHAR(64),
                        @Phone as VARCHAR(16), @Cont as VARCHAR(64),
                        @Type as VARCHAR(32), @Size as INT, 
                        @Web as VARCHAR(64), @Aff as VARCHAR(16),
                        @Anon as VARCHAR(3))
AS
BEGIN
    INSERT INTO Organizations 
        (OrgName, MailingAddress, PhoneNumber, ContactPerson, Business_Type, Business_Size, Website, Church_Affiliation, Is_Anonymous)
    VALUES
        (@OName, @Mail, @Phone, @Cont, @Type, @Size, @Web, @Aff, @Anon)

END;


GO 
CREATE PROCEDURE Query7b (@OName as VARCHAR(64), @TName as VARCHAR(64))
AS
BEGIN
    INSERT INTO Sponsors
        (TeamName, OrgName)
    VALUES     
        (@TName, @OName)
END;

/*** Queries to insert new donor and enter their donations ***/
GO 
CREATE PROCEDURE Query8a (@SS as INT, @Name as VARCHAR(64),
                        @DoB as VARCHAR(10), @Race as VARCHAR(32),
                        @Gender as VARCHAR(8), @Prof as VARCHAR(64),
                        @MAdd as VARCHAR(64), @Email as VARCHAR(32),
                        @Home as VARCHAR(16), @Work as VARCHAR(16),
                        @Cell as VARCHAR(16), @Mail as VARCHAR(3),
                        @Anon as VARCHAR(3))
AS
BEGIN
    INSERT INTO Person 
        (SocialSecurity, PersonName, DateOfBirth, Race, Gender, Profession)
    VALUES
        (@SS, @Name, @DoB, @Race, @Gender, @Prof)

    INSERT INTO ContactInfo
        (SocialSecurity, MailingAddress, Email, PhoneNumber_Home, PhoneNumber_Work, PhoneNumber_Cell, On_MailingList)
    VALUES
        (@SS, @MAdd, @Email, @Home, @Work, @Cell, @Mail)

    INSERT INTO Donors
        (SocialSecurity, Is_Anonymous)
    VALUES  
        (@SS, @Anon)
END;


GO 
CREATE PROCEDURE Query8b (@SS as INT, @Date as VARCHAR(10),
                        @Amount as INT, @Type as VARCHAR(16), 
                        @CName as VARCHAR(64), @CkNum as BIGINT,
                        @CNum as BIGINT, @CType as VARCHAR(16),
                        @EDate as VARCHAR(8))
AS
BEGIN
    INSERT INTO DonorDonations
        (SocialSecurity, Donation_Date, Amount, Donation_Type, Campaign_Name, Check_Number, Card_Number, Card_Type, Exp_Date)
    VALUES
        (@SS, @Date, @Amount, @Type, @CName, @CkNum, @CNum, @CType, @EDate)
END;

/*** Queries to insert new organization and enter their donations ***/
GO 
CREATE PROCEDURE Query9a (@OName as VARCHAR(64), @Mail as VARCHAR(64),
                        @Phone as VARCHAR(16), @Cont as VARCHAR(64),
                        @Type as VARCHAR(32), @Size as INT, 
                        @Web as VARCHAR(64), @Aff as VARCHAR(16),
                        @Anon as VARCHAR(3))
AS
BEGIN
    INSERT INTO Organizations
        (OrgName, MailingAddress, PhoneNumber, ContactPerson, Business_Type, Business_Size, Website, Church_Affiliation, Is_Anonymous)
    VALUES
        (@OName, @Mail, @Phone, @Cont, @Type, @Size, @Web, @Aff, @Anon)
END;

GO 
CREATE PROCEDURE Query9b (@OName as VARCHAR(64), @Date as VARCHAR(10),
                        @Amount as INT, @DType as VARCHAR(16), 
                        @CName as VARCHAR(64), @CkNum as BIGINT,
                        @CNum as BIGINT, @CType as VARCHAR(16),
                        @EDate as VARCHAR(8))
AS
BEGIN
    INSERT INTO OrgDonations
        (OrgName, Donation_Date, Amount, Donation_Type, Campaign_Name, Check_Number, Card_Number, Card_Type, Exp_Date)
    VALUES
        (@OName, @Date, @Amount, @DType, @CName, @CkNum, @CNum, @CType, @EDate)
END;

/*** Queries to display the name and phone number of the doctor of a client ***/
GO
CREATE PROCEDURE Query10 (@SS as INT)
AS
BEGIN
    SELECT Doctor_Name, Doctor_Number
    FROM Clients
    WHERE SocialSecurity = @SS
END;

/*** Queries to display the name and phone number of the doctor of a client ***/
GO
CREATE PROCEDURE Query11 (@Start as VARCHAR(10), @End as VARCHAR(10))
AS 
BEGIN
    SELECT SocialSecurity, SUM(Amount) as SumAmount
    FROM Expenses
    WHERE Expenses.Expense_Date >= @Start AND Expenses.Expense_Date <= @End
    GROUP BY SocialSecurity
    ORDER BY SumAmount
END;  

/*** Queries to display the volunteers that are on a team that support a client ***/
GO 
CREATE PROCEDURE Query12 (@Client as INT)
AS
BEGIN
    SELECT Person.SocialSecurity, Person.PersonName
    FROM Person, Cares_For, On_Team 
    WHERE Cares_For.SocialSecurity = @Client AND Cares_For.TeamName = On_Team.TeamName AND 
            On_Team.SocialSecurity = Person.SocialSecurity
END;

/*** Queries to display the names and contact info of clients that 
    are supported by teams sponsored by organizations with
    names that start with letters between B and K
 ***/
GO
CREATE PROCEDURE Query13 
AS
BEGIN
    SELECT DISTINCT Person.SocialSecurity, Person.PersonName, ContactInfo.MailingAddress, ContactInfo.Email, 
        ContactInfo.PhoneNumber_Home, ContactInfo.PhoneNumber_Work, ContactInfo.PhoneNumber_Cell
FROM Person, ContactInfo, Cares_For, Sponsors, Organizations
WHERE ContactInfo.SocialSecurity = Person.SocialSecurity AND Person.SocialSecurity = Cares_For.SocialSecurity AND 
        Cares_For.TeamName = Sponsors.TeamName AND Sponsors.OrgName = Organizations.OrgName AND 
        Organizations.OrgName >= 'B' AND Organizations.OrgName <= 'K'
END;

/*** Queries to display the name and total donation amount for all donors ***/
GO
CREATE PROCEDURE Query14 
AS
BEGIN
    SELECT Person.PersonName, SUM(DonorDonations.Amount) as TotalDonations, Donors.Is_Anonymous
    FROM Person, Employees, Donors, DonorDonations
    WHERE Person.SocialSecurity = Employees.SocialSecurity AND Person.SocialSecurity = Donors.SocialSecurity
            AND Donors.SocialSecurity = DonorDonations.SocialSecurity
    GROUP BY Person.PersonName, Donors.Is_Anonymous
    ORDER BY TotalDonations
END;

/*** Queries to display all teams founded before a date ***/
GO
CREATE PROCEDURE Query15 (@Date as VARCHAR(10))
AS
BEGIN
    SELECT TeamName
    FROM Teams
    WHERE Date_Formed > @Date
END;

/*** Queries to increase all employees salary by 10% that more than one team report to ***/
GO 
CREATE PROCEDURE Query16 
AS 
BEGIN
    UPDATE Employees
    SET salary = 1.1 * salary
    FROM Employees, Reports
    WHERE 1 < (SELECT COUNT(Reports.SocialSecurity) FROM Reports)
        AND Employees.SocialSecurity = Reports.SocialSecurity
END;

/*** Queries to delete clients that don't have health insurance and have
    and importance level for transportation that is <5
 ***/
GO 
CREATE PROCEDURE Query17
AS 
BEGIN
    DECLARE @SS INT 
    SELECT @SS = (SELECT DISTINCT Clients.SocialSecurity 
                                FROM Clients, Needs, Has_Insurance, InsurancePolicies
                                WHERE Clients.SocialSecurity = Needs.SocialSecurity AND Needs.Need = 'transportation' AND
                                    Needs.Importance < 5 AND 
                                    0 = (SELECT COUNT(InsurancePolicies.Policy_Type)
                                    FROM Has_Insurance, InsurancePolicies
                                    WHERE Clients.SocialSecurity = Has_Insurance.SocialSecurity AND
                                    Has_Insurance.Policy_id = InsurancePolicies.Policy_id AND 
                                    Has_Insurance.Policy_id = InsurancePolicies.Policy_id AND 
                                    InsurancePolicies.Policy_Type = 'health'))

    DELETE
    FROM Needs
    WHERE Needs.SocialSecurity = @SS

    DELETE
    FROM Has_Insurance
    WHERE Has_Insurance.SocialSecurity = @SS

    DELETE 
    FROM Clients
    WHERE Clients.SocialSecurity = @SS

END;

/*** Queries to enter new teams from specified .txt file ***/
GO
CREATE PROCEDURE Query18 (@Name as VARCHAR(64),
                            @Type as VARCHAR(16),
                            @Date as VARCHAR(10))
AS
BEGIN
    INSERT INTO Teams
        (TeamName, TeamType, Date_Formed)
    VALUES  
        (@Name, @Type, @Date)
END;

/*** Queries to send names and mailing addresses of people on the mialing list
    to a specified .txt file
 ***/
GO
CREATE PROCEDURE Query19
AS
BEGIN
    SELECT Person.PersonName, ContactInfo.MailingAddress
    FROM Person, ContactInfo
    WHERE Person.SocialSecurity = ContactInfo.SocialSecurity AND 
            ContactInfo.On_MailingList = 'Yes'
    GROUP BY Person.PersonName, ContactInfo.MailingAddress
END;
GO


/*** Error Checking ***/

INSERT INTO Person
    (SocialSecurity, PersonName)
VALUES
    (3, 'Fitzgerald');

INSERT INTO Donors
    (SocialSecurity, Is_Anonymous)
VALUES
    (11111, 'Yes');

INSERT INTO Donors
    (SocialSecurity, Is_Anonymous)
VALUES
    (9, 5)