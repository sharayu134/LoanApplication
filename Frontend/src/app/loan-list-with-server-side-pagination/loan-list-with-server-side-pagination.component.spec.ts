import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanListWithServerSidePaginationComponent } from './loan-list-with-server-side-pagination.component';

describe('LoanListWithServerSidePaginationComponent', () => {
  let component: LoanListWithServerSidePaginationComponent;
  let fixture: ComponentFixture<LoanListWithServerSidePaginationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoanListWithServerSidePaginationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanListWithServerSidePaginationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
