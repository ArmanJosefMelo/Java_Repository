# Lab Activity 1

### Description
  - This activity utilizes the Scanner to receive the user's input, compile them, and print them accordingly,
It concatenates 2 Strings into a Full Name and calculates for the user's Daily Salary.

### Variables Used
**Strings** 
- firstName
- lastName

**Integers**
- employeeAge

**Doubles** 
- hoursWorked
- hourlyWage

### Use Case
- For making a system for printing the user's informations based on the inputs.


# Lab Activity 2

### Description
  - This is a continuation of the previous activity. Now, it calculates for the user's Weekly, Monthly,
Yearly, and Net Salary by using the previous Variables with a complex calculation. It also displays the
years left for their retirement age.

### Variables Used
**Strings** 
- firstName
- lastName

**Integers** 
- employeeAge
- retireAge

**Doubles** 
- hoursWorked
- hourlyWage
- dailySalary
- weeklySalary
- monthlySalary
- yearlySalary
- netSalary

### Use Case
- For making a system for printing the user's informations based on the inputs,
including the remaining years before retirement, Weekly, Monthly, Yearly, and Net Salary.


# Lab Activity 3

### Description
  - This is a continuation of the previous activity. Now, it can terminate the program based
on invalid user inputs using conditional statement and a role code with up to 4 defined roles.

### Variables Used
**Strings** 
- firstName
- lastName

**Integers** 
- employeeAge
- retireAge
- roleCode

**Doubles** 
- hoursWorked
- hourlyWage
- dailySalary
- weeklySalary
- monthlySalary
- yearlySalary
- netSalary

### Use Case
- For making a system for printing the user's informations based on the inputs,
including the remaining years before retirement, Weekly, Monthly, Yearly, and Net Salary.
This system would be equipped to prevent Minors and Senior Citizens (unless still working)
from using the system.


# Lab Activity 4

### Description
  - This is activity is a GUI version of the first activity. It uses Java AWT to make the GUI
which includes Labels, TextFields for user input, and a TextArea for displaying the output or
an error message on invalid inputs.

### Variables Used
**Strings** 
- firstName
- lastName
- employeeAge (parse.Int)
- hoursWorked (parse.Double)
- hourlyWage (parse.Double)

### Use Case
- For making a system for a printing the user's informations based on the inputs.


# Lab Activity 5

### Description
  - This activity is a GUI Quiz App that asks the user a question and they must
make an answer input using the Radio Buttons, it contains 3 question and will
calculate the total score and display it on the Label where the questions are
also displayed. When the Quiz App is done, the Radio Buttons and Next Button are
disabled.

### Variables Used
**Strings** 
- quizQuestions []
- quizChoices [][]

**Integers** 
- correctAnswers []
- questionNum
- score

### Components
**Labels**
- questionLabel

**Buttons**
- nextButton

**Checkbox**
- answer1
- answer2
- answer3
- answer4

**CheckboxGroup**
- choicesGroup

### Use Case
- For creating a Quiz System for users to try and assess themselves, specifically
in General Computer Science


# Lab Activity 6

### Description
  - This activity now uses Java Swing in its GUI, it is a To-Do List App System
where you can add Tasks with Description and Status. All tasks are displayed in
a table located at the main and a button is placed on top where a Task Form where
you can input Task Infos and save them.

### Variables Used
**Strings** 
- columnNames []
- taskStatus []
- taskInfo [][]

**Integers** 
- taskNum

### Components
**JFrames**
- frameToDoList
- frameAddTask

**JLabels**
- labelTaskName
- labelTaskDesc
- labelTaskStatus

**JTextFields**
- tfTaskName

**JTextAreas**
- taTaskDesc

**JButtons**
- buttonOpenForm
- buttonAddItem

**JComboBoxs**
- cbStatus

**JTables**
- listAble

**JScrollPanes**
- displayTable

### Use Case
- Can be used for user's to organize and do tasks efficiently without much clutter,
and without the use of pen and paper.
