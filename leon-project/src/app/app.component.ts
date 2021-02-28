import { Component } from '@angular/core';
import { EmployeeApiService } from './services/employee-api.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  list: any = [];
  inputId: String = "";

  constructor(private service: EmployeeApiService) {}

  ngOnInit() {
    this.getEmployees();
  }

  getEmployeeById() {
    this.list = [];
    if(this.inputId != ""){
      this.service.getEmployeeById(this.inputId).subscribe((result)=>{
        this.list = result;
      });
    }else this.getEmployees();
  }

  getEmployees() {
    this.service.getEmployees().subscribe((result)=>{
      this.list = result;
    });
  }
}
