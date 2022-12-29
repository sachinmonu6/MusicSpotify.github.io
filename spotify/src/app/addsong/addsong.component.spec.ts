import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddsongComponent } from './addsong.component';

describe('AddsongComponent', () => {
  let component: AddsongComponent;
  let fixture: ComponentFixture<AddsongComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddsongComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddsongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
