import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'page-lista',
  templateUrl: 'listaDeUsuarios.html'
})
export class ListaPage {
  private users;

  constructor(public navCtrl: NavController,  public http:Http) {
    this.users = [];
    this.listarusuarios();
  }

  listarusuarios(){
    this.http.get('//http://localhost:8080/4bimWebService/resource/WebService/listaUsuarios').map(res => res.json()).subscribe(data => {
      this.users = data;
    });
  }
}
