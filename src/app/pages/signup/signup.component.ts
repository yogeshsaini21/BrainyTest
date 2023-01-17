import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/service/user.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent  {
  constructor(private userservice : UserService, private _snack : MatSnackBar){}

  public user={
    username:'',
    password:'',
    firstname:'',
    lastname:'',
    email:'',
    phone:'',
  };

  // ngOnInit(): void {

  // }
    formSubmit()
    {
      console.log(this.user);
      if(this.user.username=='' || this.user.username==null){
        this._snack.open("Username is required","ok",{duration:3000});
        return;
      }

      //add user: userservice
      this.userservice.addUser(this.user).subscribe(
        (data)=>{
          console.log(data);
          // this._snack.open("success","ok",{duration:3000});

          swal.fire('Successfully Done !!' , "User is Registered");
        },
        (error)=>{
          console.log(error);
          this._snack.open("something went wrong","ok",{duration:3000});
        }
      );

    }




}
