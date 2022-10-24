import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditAboutmeComponent } from './components/acerca-de/edit-aboutme.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditExpComponent } from './components/experiencia/edit-exp.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { EditHskillsComponent } from './components/hskills/edit-hskills.component';
import { NewHSkillsComponent } from './components/hskills/new-hskills.component';
import { EdilangComponent } from './components/languages/edilang.component';
import { NewlangComponent } from './components/languages/newlang.component';
import { LoginComponent } from './components/login/login.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { EditProjectComponent } from './components/proyectos/edit-project.component';
import { NewProjectComponent } from './components/proyectos/new-project.component';
import { EditSSkillsComponent } from './components/sskills/edit-sskills.component';
import { NewsskillsComponent } from './components/sskills/newsskills.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'editaboutme/:id', component: EditAboutmeComponent },
  { path: 'nuevaexp', component: NewExperienciaComponent },
  { path: 'editexp/:id', component: EditExpComponent },
  { path: 'nuevaeduca', component: NewEducacionComponent },
  { path: 'editeduca/:id', component: EditEducacionComponent },
  { path: 'nuevahskill', component: NewHSkillsComponent },
  { path: 'edithskill/:id', component: EditHskillsComponent },
  { path: 'nuevasskill', component: NewsskillsComponent },
  { path: 'editsskill/:id', component: EditSSkillsComponent },
  { path: 'nuevolang', component: NewlangComponent },
  { path: 'editlang/:id', component: EdilangComponent },
  { path: 'nuevoproyecto', component: NewProjectComponent },
  { path: 'editproyecto/:id', component: EditProjectComponent },

  //Para PNF
  { path: '**', pathMatch: 'full', component: PagenotfoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
