import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLadderComponent } from './create-ladder.component';

describe('CreateLadderComponent', () => {
  let component: CreateLadderComponent;
  let fixture: ComponentFixture<CreateLadderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateLadderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateLadderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
