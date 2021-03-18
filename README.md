# gender-guesser

Program made for job recruitment.

To check gender of names go to http://localhost:8080/api/start?name=[names]
For one name variant use http://localhost:8080/api/start?name=[names]20&%20variant=firstName
Second variant is used by default, or availible at http://localhost:8080/api/start?name=[names]%20&%20variant=allNames
[names] is String with Polish names seperated with space, for example "Ewa Piotr Jan"

For names list go to http://localhost:8080/api/nameList

Requirements:

Business requirements:

Create a simple Java application, that can detect gender by given name. Guess gender detection algorithm is fairly simple and is based on a list of female and male tokens, that should be packaged within JAR. Those lists should be in the form of two flat files, where each line contains a separate token. For each name, the app responds either with gender or “INCONCLUSIVE”. The gender detection algorithm should be implemented in two variants: 

Only first token of name is checked: 
Example: female tokens list = [“Maria”], male tokens list = [“Jan”]. Given name “Jan Maria Rokita”, algorithm concludes “MALE” gender, because only Jan is checked
All tokens are checked and majority rule is used:
Example: female tokens list =  [“Maria”],  male tokens list =  [“Jan”]. Given the name “Jan Maria Rokita”, the algorithm responds with “INCONCLUSIVE”. Jan is in male tokens list, Maria is in the female tokens list and Rokita is not found. Therefore no unambiguous conclusion could be found.
Example: female tokens list = [“Anna”, “Gertruda”], male tokens list = [“Zbigniew”]. Given name: “Anna Zbigniew Gertruda” algorithm responds with Female guessed gender, because 2 tokens for female > 1 token for male.
Application should expose two HTTP endpoints: one for using the gender guessing with selected variant and one for returning available tokens for each gender. First endpoint accepts a name as a single string.

Technical requirements:

Use Java and JDK >= 11
Use Gradle (preferable) or Maven to provide a task that builds JAR that is runnable on its own.
Apart from the above, any frameworks and libraries are permitted.
Code should be well tested
Code should be provided in a form of a link to a git repository.
Don’t load token lists into memory, as it could be very huge.
[Optional] Make algorithm (not to be confused with the whole app) versionable.
[Optional] Make it easily runnable through docker.

Additional notes

For the needs of this assignment, consider only two genders: female and male.
As we will be reviewing your submission thoroughly, we’re not only interested in the proposed solution, but also in your craftsmanship and that includes:
ability to write clean code - your code should be easy to follow and understand, self-documenting (we value readability over conciseness), consistent and, well tested 
knowledge and practical ability to leverage principles like SOLID, DRY, KISS
ability to maintain a project - file structure, overall content, dependency management
ability to leverage git and version control - your journey matters as much as your goal - we’ll review commit history and how your solution might have evolved over time
We hope that you’ll find this task interesting and challenging. Good luck!
