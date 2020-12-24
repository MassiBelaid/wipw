import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AdminAuthentificationService} from '../services/admin-authentification.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-admin-authentification',
  templateUrl: './admin-authentification.component.html',
  styleUrls: ['./admin-authentification.component.css']
})
export class AdminAuthentificationComponent implements OnInit {
  adminForm: FormGroup;
  erreurFormulaire: string;
  token: string;

  constructor(private formBuilder: FormBuilder,
              private adminAuthentificationService: AdminAuthentificationService,
              private router: Router) { }

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
            localStorage.setItem('token', adminConnexion.token);
            console.log(localStorage.getItem('token'));
            this.router.navigate(['/']);
        } else {
          this.erreurFormulaire = 'Mauvais identifiants de connexion';
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }

}
