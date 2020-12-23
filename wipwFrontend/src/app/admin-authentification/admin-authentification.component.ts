import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AdminAuthentificationService} from '../services/admin-authentification.service';

@Component({
  selector: 'app-admin-authentification',
  templateUrl: './admin-authentification.component.html',
  styleUrls: ['./admin-authentification.component.css']
})
export class AdminAuthentificationComponent implements OnInit {
  adminForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private adminAuthentificationService: AdminAuthentificationService) { }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.adminForm = this.formBuilder.group({
      email: ['', [Validators.email, Validators.required]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }


  onSubmitForm() {
    this.adminAuthentificationService.connexion(this.adminForm.value).subscribe(
      (adminConnexion) => {
        if (adminConnexion.status) {
            console.log('Vous êtes connecté');
        } else {
          console.log('erreur identifiants');
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
