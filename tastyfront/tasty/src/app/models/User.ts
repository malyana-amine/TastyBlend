// export class User {
//     firstname!: String;
//     lastname!: String;
//     email: String | undefined;
//     password!: String;
// }

// models/User.ts

export class User {
    firstname: string;
    lastname: string;
    email: string;
    password: string;
  
    constructor() {
      this.firstname = '';
      this.lastname = '';
      this.email = '';
      this.password = '';
    }
  }
  