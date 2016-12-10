import { Component } from '@angular/core';
import { NavController , NavParams } from 'ionic-angular';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'page-cadastro',
  templateUrl: 'novoUsuario.html'
})
export class Cadastro {
public user;

  constructor(public navCtrl: NavController, public params: NavParams, public http:Http) {
    this.user={};
}

cadastrar(){
  console.log(this.user);
  this.http.post('http://localhost:8080/4bimWebService/resource/WebService/cadastrar', this.user).map(res => res.json()).subscribe(data => {
      this.user = {};
  });
}
