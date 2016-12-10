import { Component } from '@angular/core';
import { NavController , NavParams } from 'ionic-angular';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { HomePage } from 'inicio';

@Component({
  selector: 'page-inicio',
  templateUrl: 'inicio.html'
})
export class InicioPage {
public user;

  constructor(public navCtrl: NavController, public params: NavParams, public http:Http) {
    this.user={};
  }

login(){
  console.log(this.user);
  this.http.post('http://localhost:8080/4bimWebService/resource/WebService/autenticar', this.user).map(res => res.json()).subscribe(data => {
      this.user = {};
      });
  }
}
