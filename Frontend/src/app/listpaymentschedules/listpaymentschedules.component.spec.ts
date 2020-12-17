import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListpaymentschedulesComponent } from './listpaymentschedules.component';

describe('ListpaymentschedulesComponent', () => {
  let component: ListpaymentschedulesComponent;
  let fixture: ComponentFixture<ListpaymentschedulesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListpaymentschedulesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListpaymentschedulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
