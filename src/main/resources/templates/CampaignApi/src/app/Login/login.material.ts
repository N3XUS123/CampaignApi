import { NgModule } from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {MatTabsModule} from '@angular/material/tabs';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';

@NgModule({
  imports: [MatButtonModule, MatCheckboxModule, MatTabsModule, MatInputModule, MatFormFieldModule, MatIconModule, MatSelectModule],
  exports: [MatButtonModule, MatCheckboxModule, MatTabsModule, MatInputModule, MatFormFieldModule, MatIconModule, MatSelectModule],
})
export class MyMaterialModule { }