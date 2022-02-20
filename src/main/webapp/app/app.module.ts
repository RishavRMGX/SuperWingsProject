import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { SuperWingsProjectSharedModule } from 'app/shared/shared.module';
import { SuperWingsProjectCoreModule } from 'app/core/core.module';
import { SuperWingsProjectAppRoutingModule } from './app-routing.module';
import { SuperWingsProjectHomeModule } from './home/home.module';
import { SuperWingsProjectEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    SuperWingsProjectSharedModule,
    SuperWingsProjectCoreModule,
    SuperWingsProjectHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    SuperWingsProjectEntityModule,
    SuperWingsProjectAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class SuperWingsProjectAppModule {}
