import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewSongComponent } from './add-new-song.component';

describe('AddNewSongComponent', () => {
  let component: AddNewSongComponent;
  let fixture: ComponentFixture<AddNewSongComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddNewSongComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewSongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
