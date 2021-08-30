# Fair Burger

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
* AWS RDS
* Heroku 

### [5] Screenshots
Home screen of Book Buddy:

![Mohmed Ishak](https://user-images.githubusercontent.com/52876913/131381266-9a883e16-5d25-4f53-95fd-d398e5734253.png)

### [6] How to Run the Project Locally
If you want to just view the completed, hosted version of this app, refer point 1 above. Otherwise, keep reading. Fork this repository and clone it to your machine. Make sure you've got Node, MongoDB, and Expo CLI installed on your machine. You may Google how to do so as it's very simple and I don't want to pollute my README file and bore you with too much of instructions. In the backend folder, add a .env file and paste the following code:
    
    NODE_ENV=development
    PORT=5000
    MONGO_URI=mongodb://localhost:27017/temporaryDB
    JWT_SECRET_KEY=thisisafakejwtsecretkey
Then install all frontend and backend dependencies by typing ```npm i``` in terminal for frontend and backend folder individually. Then, run the backend server by typing ```nodemon index.js``` in the terminal under backend folder. Then, launch the app from the frontend folder in the terminal by typing ```npm start```. A website will be launched. Follow the instructions in that site to view the app on your mobile phone. If the instructions change in future, please paste this phrase to Google search engine and do a super quick research: "How to run an Expo app from my mobile phone".  

### [7] Hosting
* Frontend: Expo
* Backend: Heroku
* Database: MongoDB Atlas
