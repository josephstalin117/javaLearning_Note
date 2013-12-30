# 学生选课系统   
# course registration system

***

## 第1章 需求分析  

### 1.1开发背景  

随着无纸化办公的一步步实现，信息的自动处理以及网络式的信息交互方式越来越被人们认可和应用。让计算机来管理学生的信息是现在各个高校都在积极进行的工作之一。由于管理模式多样化，传统的选课方式已不能满足需求，在改革和需求的推动下，开发了网上选课系统。网上选课可使学生自主选择学习内容，可根据自身需求安排学习时间。网上选课系统的自主性，灵活性逐渐替代了传统手工选课的管理模式，提高了教务管理的效率。  
网上选课是学校教务管理系统的重要组成部分，直接关系着学生的选课。学生选课系统以选课为中心，包括对课程信息的维护，学生信息的维护，任课教师的安排，课程的安排等。主要工作是对课程及学生信息的添加，修改和删除；对任课教师的授课工作安排和对开课课程的安排和管理。主要功能：能准确快速的动态生成不同学生可选的课程，并根据学生的需要选择和退选课程，便捷的对基础信息进行处理。轻松的完成学生的选课。  
论文对基于学分制的学生选课管理系统所采用的开发平台、关键技术给予详细的介绍并按照软件工程的要求，从需求分析开始，经过总体设计最后到详细设计，完成对整个系统的设计。并简要说明在完成过程中所碰到的问题及解决经验。  


### 1.2 系统目标与需求分析  

![images](images/requirements.png)

系统的主要用户是**管理员**、**教师**和**学生**，管理员可以通过超级用户身份登录,对系统进行全面的管理维护, 老师、学生以不同用户的身份进入不同的界面，执行不同的操作拥有各自的权限。  
该系统用于提高教务处的工作效率，方便用户之间信息的交流，简化学生选课的流程，使选课管理工作更规范化，系统化，程序化，提高信息处理的速度和准确性，能够及时、准确、有效的查询和修改选课排课相关信息。在学校内部的现有局域网这个网络环境下,信息由各用户在规定的权限下在各自的工作站上录入，信息上网后各用户可查询，选课，修改，管理，达到信息共享。  


### 1.3 系统参与者

![images](images/adminRequirements.jpg)


* **排课的功能需求**

1. 说明：学生选课之前，院系教务管理人员要合理安排课程。
2. 录入：被排课程的课程号，各课程的上课地点、时间、授课教师。
3. 加工：系统对教务管理员提交的排课表进行验证，验证成功之后，把排课表输入到数据库中，更新数据库。
4. 输出：输出排课成功与否的提示信息，并将排课成功的排课表分年级输出到屏幕上并发布选课信息。


* **基本资料管理的功能需求**

1. 说明：此功能实现对学生、教师、课程基本资料的添加、删除、更新、查询。管理员利用数据库进行管理。
2. 录入：输入学生、教师、课程的基本属性。详见数据字典部分。
3. 加工：教务管理员对所提交的学生，教师，课程信息通过系统进行检查、验证，验证通过之后把有关信息录入数据库中，更新数据库。
4. 输出：输出学生，教师，课程基本资料信息表。


* **设置各级用户的权限功能需求**

1. 说明：此功能实现对各用户赋予不同的用户权限。教务管理员利用数据库管理技术进行权限设置。
2. 录入：无
3. 加工：教务管理员对各用户赋予不同的用户权限，系统验证这些权限设置，通过后，进行系统更新。
4. 输出：给出所设置的用户的权限说明。


#### 学生选课子系统
![images](images/studentRequirements.png)

* **查询的功能需求**

1. 说明：此功能使学生可以查询本学期的开课计划，包括课程的详细信息，专业课查询，选修课查询，已选课查询等。
2. 录入：通过友好的交互界面，使学生通过点击鼠标就可以实现各种查询功能。
3. 加工：系统通过点击鼠标所提交的查询请求，利用数据库系统的查询功能查询出符合要求的记录。
4. 输出：在屏幕上显示查询后的结果，通常以报表的形式显示。


* **选课的功能需求**

1. 说明：此功能使学生实现在网上选课。
2. 录入：通过友好的交互界面，使学生通过点击鼠标选择课程号，是否购买教材等。
3. 加工：学生提交要选课程的表单后，系统进行验证表单中的数据，选课号是否正确，学分是否已满25学分，不能重课。
4. 输出：显示课程是否选中的标记。


* **退课的功能需求**

1. 说明：此功能使学生实现在网上退课。
2. 录入：通过友好的交互界面，使学生通过点击鼠标进行操作，提交数据。
3. 加工：系统进行验证提交的数据，不能删除空数据，验证通过后删除课程，并给出提示信息。
4. 输出：输出删除成功的标记，重设课程是否选中的标记 。

#### 教师管理子系统

![images](images/techersRequirements.png)

* **选课查询的功能需求**

1. 说明：此功能使教师查询选课的情况。
2. 录入：教师所教课程的课程号，实现时应是鼠标操作。
4. 输出：将查询后的结果输出到屏幕上，应包括课程的基本信息。


### 1.4 用例模型  

![images](images/UseCaseDiagram/RoleOfSystemCaseDiagram.png)

系统角色用例图  

![images](images/UseCaseDiagram/UserRoleUseDiagram.png)

用户角色用例图  

![images](images/UseCaseDiagram/AdminRoleUseCaseDiagram.png)

管理员角色用例图  

![images](images/UseCaseDiagram/StudentRoleUseCaseDiagram.png)

学生角色用例图  

![images](images/UseCaseDiagram/TeacherRoleUseCaseDiagram.png)

教师角色用例图  


### 1.5 用例描述  

#### 用户角色用例图

* 用户登录
* 用户信息管理
* 课程信息查询

异常部分：  

* 用户忘记密码
* 用户不存在

#### 管理员角色用例图

* 角色管理（学生、用户、教师增删改查）
* 成绩管理（成绩分析、修改）
* 课程信息管理（课程、课程计划）

异常部分：  

* 成绩为负分
* 学生号用户号重复

#### 学生角色用例图

* 学生选课
* 学生查询(成绩、信息)

异常部分：  

* 学生不存在
* 学生信息无法查询

#### 教师角色用例图

* 输入学生成绩
* 修改个人信息

异常部分：  

* 教师不存在

### 1.6 用活动图描述用例  

![images](images/ActivityDiagram/AdminNewActivity.png)

管理员添加角色（学生、教师、课程、班级）活动图（以添加学生为例）  

![images](images/ActivityDiagram/StudentCheckActivity.png)

学生查询成绩活动图  

![images](images/ActivityDiagram/StudentSelectCourseActivity.png)

学生选课活动图  

## 第2章 对象类建模  
	
### 2.1 系统静态模型  

![images](images/ClassDiagram/DAOFactory.png)

系统整体架构基于抽象工厂模式。通过`DAOFactory`抽象工厂使用一个工厂等级结构创建出分属于不同产品等级结构的一个产品族中的所有对象。  

### 2.1.1 建立对象类  

![images](images/ClassDiagram/AdminDAOpattern.png)

管理员对象类  

![images](images/ClassDiagram/CourseDAOpattern.png)

课程对象类  

![images](images/ClassDiagram/ModelSelectDAOpattern.png)

课程选择对象类  

![images](images/ClassDiagram/PlanDAOpattern.png)

课程计划（班级）对象类  

![images](images/ClassDiagram/StudentDAOpattern.png)

学生对象类   

![images](images/ClassDiagram/TeacherDAOpattern.png)

教师对象类  

![images](images/ClassDiagram/UserDAOpattern.png)

用户对象类  

### 2.2 系统动态模型  
### 2.2.1 顺序图  

#### 1、管理员顺序图  

![images](images/SequenceDiagram/AdminSequence/InsertCourseSequence.png)

增加课程顺序图  

![images](images/SequenceDiagram/AdminSequence/InsertPlanSequence.png)

增加课程计划顺序图  

![images](images/SequenceDiagram/AdminSequence/InsertStudentSequence.png)

增加学生顺序图  

![images](images/SequenceDiagram/AdminSequence/InsertTeacherSequence.png)

增加教师顺序图  

![images](images/SequenceDiagram/AdminSequence/UpdateScoreSequence.png)

更新成绩顺序图  

![images](images/SequenceDiagram/AdminSequence/UpdateStudentSequence.png)

更新用户信息顺序图（以学生对象为例）  


#### 2、学生顺序图  

![images](images/SequenceDiagram/StudentSequence/CheckMarkSequence.png)

成绩查询顺序图  

![images](images/SequenceDiagram/StudentSequence/SelectCourseSequence.png)

学生选课顺序图  

#### 3、教师顺序图  

![images](images/SequenceDiagram/TeacherSequence/InsertStudentScoreSequence.png)

教师录入成绩顺序图  

#### 4、用户顺序图  

![images](images/SequenceDiagram/UserSequence/UpdateInfoSequence.png)

用户修改信息顺序图  

### 2.2.2 协作图  

#### 1、管理员协作图  

![images](images/CollaborationDiagram/AdminCollaboration/InsertCourseCollaboration.png)

增加课程协作图  

![images](images/CollaborationDiagram/AdminCollaboration/InsertPlanCollaboration.png)

增加课程计划协作图  

![images](images/CollaborationDiagram/AdminCollaboration/InsertStudentCollaboration.png)

增加学生协作图  

![images](images/CollaborationDiagram/AdminCollaboration/InsertTeacherCollaboration.png)

增加教师协作图  

![images](images/CollaborationDiagram/AdminCollaboration/UpdateCourseCollaboration.png)

更新课程协作图  

![images](images/CollaborationDiagram/AdminCollaboration/UpdateStudentCollaboration.png)

更新用户信息协作图（以学生对象为例）  

#### 2、学生协作图  

![images](images/CollaborationDiagram/StudentCollaboration/CheckMarkCollaboration.png)

成绩查询顺序图  

![images](images/CollaborationDiagram/StudentCollaboration/SelectCourseCollaboration.png)

学生选课顺序图  

#### 3、教师协作图  

![images](images/CollaborationDiagram/TeacherCollaboration/InsertStudentScoreCollaboration.png)

教师录入成绩协作图  

#### 4、用户协作图  

![images](images/CollaborationDiagram/UserCollaboration/UpdateInfoCollaboration.png)

用户修改信息协作图  

	

## 第3章 系统设计

### 3.1系统架构设计  

![images](images/ClassDiagram/DAOFactory.png)

### 3.2 数据库设计  

>学生信息表 cr_stuInfo D2  
>>用户名 uuid int(11) unsigned  
>>学号 sid primary key int(11) unique  
>>姓名 sname varchar(50)  
>>性别 sex tinyint(1)  
>>院号 did int(4)  
>>专业号 spid int(6)  
>>出生日期 birthday date  
>>入学时间 enrollment date  

>教师信息表 cr_teaInfo D1
>>用户名 uuid int(11) unsigned unique  
>>教师号 tid primary key int(11) unique  
>>姓名 tname varchar(50)  
>>性别 sex tinyint(1)  
>>出生日期 birthday date  
>>院号 did int(4)  
>>专业号 spid int(6)  
>>职称号 proid tinyint(2)  

>职称表 cr_professional  
>>职称号 proid tinyint(2) primary key  
>>职称名 proname varchar(50)  

>课程表 cr_curriculum D6  
>>课程号 cid primary key int(11) unsigned  
>>课程名 cname varchar(50)  
>>课程简介 cintroduction text  
>>课程学分 credit tinyint(2)  
>>课时 period int(3)  
>>限选专业号 limit int(6)  
>>能否留言 cgestbook tinyint(1)  
>>学生评分 mark int(3)  

>院系表 cr_department
>>院号 did int(4)  
>>院名 dname varchar(50)  

>专业表 cr_specialty
>>专业号 spid int(6)  
>>专业名 spname varchar(50)  
>>院号 did int(4)  

>课程留言表 cr_message D9
>>学号 sid primary key int(11)  
>>课程号 cid primary key int(11)  
>>留言内容 messagecontent text  
>>留言时间 messagetime date  
>>ip地址 ipaddress varchar(15)  

>课程计划表 cr_plan D3
>>课程号 cid primary key int(11)  
>>教师号 tid primary key int(11)  
>>上课地点 location int(6)  
>>开课容量 capacity int(3)  
>>预修课程 prepare int(11)  
>>上课时间 classtime varchar(10)  

>选课表 cr_modelselect D5
>>学号 sid primary key int(11)  
>>课程号 cid primary key int(11)  
>>是否接受 accept tinyint(1)  
>>成绩 score int(3)  

>帐号密码表 cr_account D7
>>帐号 uuid primary key int(11) unsigned  
>>昵称 nackname varchar(50)  
>>角色 role tiny(1)  
>>邮箱 email varchar(50)  
>>密码 password char(32)  
>>头像 picture varchar(50)  
>>安全问题 secuquestion varchar(50)  
>>安全问题答案 secuanswer varchar(50)  

>管理员 cr_admin D10
>>帐号 uuid int(11)  
>>用户名 username varchar(50)  

### 3.4 系统部署  

![images](images/Deploy.png)

基于JSP+TOMCAT+MySQL的系统部署。  