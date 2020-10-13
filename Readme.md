<h1>Dynamic Form Builder</h1>

<h5> Here, a user can create a dynamic form with variable number of questions and they have three types of options available for a question . It can be 
MCQ,Text, Date.</h5>

<h6> Here , I have used MongoDb for Database

There are three documents here, first one is User document.
<br>
User:
<br>

     {
        "id",
        "name",
        "e_mail"
      }
<br>
Form:
<br>

        {   "formid" ,
            "uid",
            "qstn_list":[
            {
                "type":[MCQ,Text,Date],
                "qstn",
                "mcq":[option1,..]
            }
            ]
        }

Response:
<br>

        {  "formid" ,
           "uid",
           "resp_list":[
                        {
                            "type":[MCQ,Text,Date],
                            "ans"
                        }
                        ]
        }
</h6>