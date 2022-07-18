DROP TABLE IF EXISTS Sponsors;
DROP TABLE IF EXISTS Reports;
DROP TABLE IF EXISTS Leads;
DROP TABLE IF EXISTS On_Team;
DROP TABLE IF EXISTS Cares_For;
DROP TABLE IF EXISTS Has_Insurance;
DROP TABLE IF EXISTS Affiliated;
DROP TABLE IF EXISTS OrgDonations;
DROP TABLE IF EXISTS DonorDonations;
DROP TABLE IF EXISTS Expenses;
DROP TABLE IF EXISTS HoursWorked;
DROP TABLE IF EXISTS Needs;
DROP TABLE IF EXISTS EmergencyContact;
DROP TABLE IF EXISTS ContactInfo;
DROP TABLE IF EXISTS InsurancePolicies;
DROP TABLE IF EXISTS Organizations;
DROP TABLE IF EXISTS Teams;
DROP TABLE IF EXISTS Donors;
DROP TABLE IF EXISTS Employees;
DROP TABLE IF EXISTS Volunteers;
DROP TABLE IF EXISTS Clients;
DROP TABLE IF EXISTS Person;

DROP INDEX IF EXISTS EmergencyContact.emergency
DROP INDEX IF EXISTS Needs.NeedName
DROP INDEX IF EXISTS HoursWorked.team
DROP INDEX IF EXISTS Expenses.Edate
DROP INDEX IF EXISTS DonorDonations.dondate
DROP INDEX IF EXISTS Affiliated.OName
DROP INDEX IF EXISTS OrgDonations.OrgDate

/*Initialize table for People*/
CREATE TABLE Person(
    SocialSecurity INT,
    PersonName VARCHAR(64) NOT NULL,
    DateOfBirth VARCHAR(10) NOT NULL,
    Race VARCHAR(32) NOT NULL,
    Gender VARCHAR(8) NOT NULL,
    Profession VARCHAR(64) NOT NULL,
    PRIMARY KEY (SocialSecurity));

/*Initialize table for Clients*/
CREATE TABLE Clients (
    SocialSecurity INT,
    Doctor_Name VARCHAR(64) NOT NULL,
    Doctor_Number VARCHAR(16) NOT NULL,
    Attorney_Name VARCHAR(64) NOT NULL,
    Attorney_Number VARCHAR(16) NOT NULL,
    Assignment_Date VARCHAR(10) NOT NULL,
    PRIMARY KEY (SocialSecurity),
    FOREIGN KEY (SocialSecurity) REFERENCES Person);

/*Initialize table for Volunteers*/
CREATE TABLE Volunteers (
    SocialSecurity INT,
    Date_Joined VARCHAR(10) NOT NULL,
    Course_Date VARCHAR(10) NOT NULL,
    Course_Location VARCHAR(32) NOT NULL,
    PRIMARY KEY (SocialSecurity),
    FOREIGN KEY (SocialSecurity) REFERENCES Person);

/*Initialize table for Employees*/
CREATE TABLE Employees (
    SocialSecurity INT,
    Salary INT NOT NULL, 
    Marital_Status VARCHAR(10) NOT NULL,
    Hire_Date VARCHAR(10) NOT NULL,
    PRIMARY KEY (SocialSecurity),
    FOREIGN KEY (SocialSecurity) REFERENCES Person);

/*Initialize table for Donors*/
CREATE TABLE Donors (
    SocialSecurity INT,
    Is_Anonymous VARCHAR(3) NOT NULL,
    PRIMARY KEY (SocialSecurity),
    FOREIGN KEY (SocialSecurity) REFERENCES Person);

/*Initialize table for Teams*/
CREATE TABLE Teams (
    TeamName VARCHAR(64),
    TeamType VARCHAR(16) NOT NULL,
    Date_Formed VARCHAR(15) NOT NULL,
    PRIMARY KEY (TeamName));

/*Initialize table for Organizations*/
CREATE TABLE Organizations (
    OrgName VARCHAR(64),
    MailingAddress VARCHAR(64) NOT NULL,
    PhoneNumber VARCHAR(16) NOT NULL,
    ContactPerson VARCHAR(64) NOT NULL,
    Business_Type VARCHAR(32),
    Business_Size INT,
    Website VARCHAR(64),
    Church_Affiliation VARCHAR(16),
    Is_Anonymous VARCHAR(3),
    PRIMARY KEY (OrgName));

/*Initialize table for Insurance Policies*/
CREATE TABLE InsurancePolicies (
    Policy_id VARCHAR(10),
    Provider_id VARCHAR(10) NOT NULL,
    Provider_Address VARCHAR(64) NOT NULL,
    Policy_Type VARCHAR(16) NOT NULL,
    PRIMARY KEY (Policy_id));

/*Initialize table for Contact Info*/
CREATE TABLE ContactInfo (
    SocialSecurity INT,
    MailingAddress VARCHAR(64) NOT NULL,
    Email VARCHAR(32) NOT NULL,
    PhoneNumber_Home VARCHAR(16),
    PhoneNumber_Work VARCHAR(16),
    PhoneNumber_Cell VARCHAR(16),
    On_MailingList VARCHAR(3) NOT NULL,
    PRIMARY KEY (SocialSecurity),
    FOREIGN KEY (SocialSecurity) REFERENCES Person);

/*Initialize table for Emergency Contact*/
CREATE TABLE EmergencyContact (
    SocialSecurity INT,
    ContactName VARCHAR(64),
    ContactInfo VARCHAR(64) NOT NULL,
    Relationship VARCHAR(16) NOT NULL,
    PRIMARY KEY (SocialSecurity, ContactName),
    FOREIGN KEY (SocialSecurity) REFERENCES Person);

/*Initialize index for emergencies*/
CREATE INDEX emergency
ON EmergencyContact(ContactName)

/*Initialize table for Needs*/
CREATE TABLE Needs (
    SocialSecurity INT,
    Need VARCHAR(16) NOT NULL,
    Importance INT NOT NULL,
    PRIMARY KEY (SocialSecurity),
    FOREIGN KEY (SocialSecurity) REFERENCES Clients);

/*Initialize index for needs*/
CREATE INDEX NeedName
ON Needs(Need)

/*Initialize table for Hours Worked*/
CREATE TABLE HoursWorked (
    SocialSecurity INT,
    TeamName VARCHAR(64),
    MonthWorked VARCHAR(10) NOT NULL,
    WorkedHours INT NOT NULL,
    PRIMARY KEY (SocialSecurity, TeamName),
    FOREIGN KEY (SocialSecurity) REFERENCES Volunteers,
    FOREIGN KEY (TeamName) REFERENCES Teams);

/*Initialize index for teams*/
CREATE INDEX team
ON HoursWorked(TeamName)

/*Initialize table for Expenses*/
CREATE TABLE Expenses (
    SocialSecurity INT,
    Expense_Date VARCHAR(10),
    Amount INT,
    Expense_Description VARCHAR(150),
    PRIMARY KEY (SocialSecurity, Expense_Date, Amount, Expense_Description),
    FOREIGN KEY (SocialSecurity) REFERENCES Employees);

/*Initialize index by expense dates*/
CREATE INDEX Edate
ON Expenses(Expense_Date)

/*Initialize table for Donor Donations*/
CREATE TABLE DonorDonations (
    SocialSecurity INT,
    Donation_Date VARCHAR(10) NOT NULL,
    Amount INT NOT NULL,
    Donation_Type VARCHAR(16) NOT NULL,
    Campaign_Name VARCHAR(64),
    Check_Number BIGINT,
    Card_Number BIGINT,
    Card_Type VARCHAR(16),
    Exp_Date VARCHAR(8),
    PRIMARY KEY (SocialSecurity, Donation_Date, Amount, Donation_Type),
    FOREIGN KEY (SocialSecurity) REFERENCES Donors);

/*Initialize index by donation date*/
CREATE INDEX dondate
ON DonorDonations(Donation_Date)

/*Initialize table for Affiliated Organizations*/
CREATE TABLE Affiliated (
    SocialSecurity INT,
    OrgName VARCHAR(64),
    PRIMARY KEY (SocialSecurity, OrgName),
    FOREIGN KEY (SocialSecurity) REFERENCES Person,
    FOREIGN KEY (OrgName) REFERENCES Organizations);

/*Initialize index by affiliaiton*/
CREATE INDEX OName
ON Affiliated(OrgName)

/*Initialize table for Organization Donations*/
CREATE TABLE OrgDonations (
    OrgName VARCHAR(64),
    Donation_Date VARCHAR(10),
    Amount INT,
    Donation_Type VARCHAR(16),
    Campaign_Name VARCHAR(64),
    Check_Number BIGINT,
    Card_Number BIGINT,
    Card_Type VARCHAR(16),
    Exp_Date VARCHAR(8),
    PRIMARY KEY (OrgName, Donation_Date, Amount, Donation_Type),
    FOREIGN KEY (OrgName) REFERENCES Organizations);

/*Initialize index by organization donation date*/
CREATE INDEX OrgDate
ON OrgDonations(Donation_Date)

/*Initialize table for Insurance Check*/
CREATE TABLE Has_Insurance (
    SocialSecurity INT,
    Policy_id VARCHAR(10),
    PRIMARY KEY (SocialSecurity, Policy_id),
    FOREIGN KEY (SocialSecurity) REFERENCES Clients,
    FOREIGN KEY (Policy_id) REFERENCES InsurancePolicies);

/*Initialize table for Care Givers*/
CREATE TABLE Cares_For (
    SocialSecurity INT,
    TeamName VARCHAR(64),
    Is_Active VARCHAR(3) NOT NULL,
    PRIMARY KEY (SocialSecurity, TeamName),
    FOREIGN KEY (SocialSecurity) REFERENCES Clients,
    FOREIGN KEY (TeamName) REFERENCES Teams);

/*Initialize table for Team Check*/
CREATE TABLE On_Team (
    SocialSecurity INT,
    TeamName VARCHAR(64),
    Is_Active VARCHAR(3) NOT NULL,
    PRIMARY KEY (SocialSecurity, TeamName),
    FOREIGN KEY (SocialSecurity) REFERENCES Volunteers);

/*Initialize table for Team Leads*/
CREATE TABLE Leads (
    SocialSecurity INT,
    TeamName VARCHAR(64),
    Is_Active VARCHAR(3) NOT NULL,
    PRIMARY KEY (SocialSecurity, TeamName),
    FOREIGN KEY (SocialSecurity) REFERENCES Volunteers,
    FOREIGN KEY (TeamName) REFERENCES Teams);

/*Initialize table for Reports*/
CREATE TABLE Reports (
    SocialSecurity INT,
    TeamName VARCHAR(64),
    Report_Date VARCHAR(10) NOT NULL,
    Report_Description VARCHAR(150) NOT NULL,
    PRIMARY KEY (SocialSecurity, TeamName),
    FOREIGN KEY (SocialSecurity) REFERENCES Employees,
    FOREIGN KEY (TeamName) REFERENCES Teams);

/*Initialize table for Sponsors*/
CREATE TABLE Sponsors (
    TeamName VARCHAR(64),
    OrgName VARCHAR(64),
    PRIMARY KEY (TeamName, OrgName),
    FOREIGN KEY (TeamName) REFERENCES Teams,
    FOREIGN KEY (OrgName) REFERENCES Organizations);


