# Book Buddy

# WARNING: if Book Buddy replies you with [empty response], wait for 1 minute, reload the app, and chat with Book Buddy. It will work now because the backend is set to sleep after a couple of hours of inactivity (cold start problem).

### [1] See Live Version Immediately
Head over to this link: https://bot.dialogflow.com/7cddcaf6-d319-4c2c-b5a0-b14ab4275e5c

### [2] Introduction
Book Buddy is an intelligent assistant (for a fake book library) built using Spring Boot and Dialogflow. You can ask Book Buddy about the authors it knows (try saying "list all authors") which is one of the main entry points to this bot and more about the books they wrote down the conversation. It is built using Dialogflow, Spring Boot, MySQL, and other technologies.

### [3] Technologies Used/Features Implemented
* Dialogflow
* Spring Boot
* Spring Data JPA
* Spring REST
* MySQL
* Ngrok (for webhook callback from Dialogflow to localhost/developent environment)
* AWS RDS (Relational Database Service)
* Heroku 

### [4] Screenshots
Home screen of Book Buddy:

![Mohmed Ishak](https://user-images.githubusercontent.com/52876913/131381266-9a883e16-5d25-4f53-95fd-d398e5734253.png)

### [5] How to Run the Project Locally
If you want to just view the completed, hosted version of this app, refer point 1 above. Otherwise, keep reading. Please take note that this is just the backend of Book Buddy as there's no way to share my frontend (Dialogflow) project unless I know your email. If you do want to inspect the implementation on Dialogflow, message me and I will add you as a collaborator. If you're interested to check the backend out, fork this repository and clone it to your machine. Make sure you've got the right tools installed to run a Spring Boot project with MySQL (Google how to do so as I don't want to write a long, confusing article). In the resources folder, there's a file called `application.properties`. Change the username and password to that of your local MySQL database. The database URL is already good but make sure you manually create a database called `bookbuddydatabase` before running the application. 

### [6] Hosting
* Frontend: Automatically hosted by Dialogflow
* Backend: Heroku
* Database: AWS RDS (Relational Database Service)
