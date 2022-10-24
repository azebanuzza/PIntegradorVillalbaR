import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LogoAPComponent } from './components/logo-ap/logo-ap.component';
import { SocialComponent } from './components/social/social.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercaDeComponent } from './components/acerca-de/acerca-de.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { interceptorProvider } from './service/interceptor-service';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { EditAboutmeComponent } from './components/acerca-de/edit-aboutme.component';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { environment } from '../environments/environment';
import { provideStorage, getStorage } from '@angular/fire/storage';
import { EditExpComponent } from './components/experiencia/edit-exp.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { HSkillsComponent } from './components/hskills/hskills.component';
import { NewHSkillsComponent } from './components/hskills/new-hskills.component';
import { EditHskillsComponent } from './components/hskills/edit-hskills.component';
import { SskillsComponent } from './components/sskills/sskills.component';
import { EditSSkillsComponent } from './components/sskills/edit-sskills.component';
import { NewsskillsComponent } from './components/sskills/newsskills.component';
import { LanguagesComponent } from './components/languages/languages.component';
import { EdilangComponent } from './components/languages/edilang.component';
import { NewlangComponent } from './components/languages/newlang.component';
import { NewProjectComponent } from './components/proyectos/new-project.component';
import { EditProjectComponent } from './components/proyectos/edit-project.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoAPComponent,
    SocialComponent,
    BannerComponent,
    AcercaDeComponent,
    ExperienciaComponent,
    EducacionComponent,
    ProyectosComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    PagenotfoundComponent,
    NewExperienciaComponent,
    EditAboutmeComponent,
    EditExpComponent,
    NewEducacionComponent,
    EditEducacionComponent,
    HSkillsComponent,
    NewHSkillsComponent,
    EditHskillsComponent,
    SskillsComponent,
    EditSSkillsComponent,
    NewsskillsComponent,
    LanguagesComponent,
    EdilangComponent,
    NewlangComponent,
    NewProjectComponent,
    EditProjectComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideStorage(() => getStorage()),
  ],
  providers: [interceptorProvider],
  bootstrap: [AppComponent],
})
export class AppModule {}
